provider "aws" {
  region                  = "us-east-1"
  shared_credentials_file = pathexpand("~/.aws/credentials")
  profile                 = "thall-udemy-terraform"
}

resource "aws_instance" "db" {
  ami           = "ami-0742b4e673072066f"
  instance_type = "t2.micro"
  tags = {
    Name = "DB Server"
  }
}

resource "aws_instance" "web" {
  ami             = "ami-0742b4e673072066f"
  instance_type   = "t2.micro"
  tags = {
    Name = "Web Server"
  }
  security_groups = [
    aws_security_group.web_traffic.name]

  user_data = file("server-script.sh")
}

resource "aws_eip" "web_server_ip" {
  instance = aws_instance.web.id
}

#tfsec:ignore:AWS009 tfsec:ignore:AWS008
resource "aws_security_group" "web_traffic" {
  name = "SG for WebServer"
  description = "Webtraffic"

  dynamic "ingress" {
    iterator = port
    for_each = var.ingress_rules
    content {
      from_port   = port.value
      protocol    = "TCP"
      to_port     = port.value
      cidr_blocks = [
        "0.0.0.0/0"]
    }
  }

  dynamic "egress" {
    iterator = port
    for_each = var.egress_rules
    content {
      from_port   = port.value
      protocol    = "TCP"
      to_port     = port.value
      cidr_blocks = [
        "0.0.0.0/0"]
    }
  }
}

output "PrivateIP" {
  value = aws_instance.db.private_ip
}

output "PublicIP" {
  value = aws_eip.web_server_ip.public_ip
}
