provider "aws" {
  region                  = "us-east-1"
  shared_credentials_file = pathexpand("~/.aws/credentials")
  profile                 = "thall-udemy-terraform"
}

resource "aws_instance" "ec2" {
  ami           = "ami-0742b4e673072066f"
  instance_type = "t2.micro"
  security_groups = [aws_security_group.webtraffic.name]
}

#tfsec:ignore:AWS009 tfsec:ignore:AWS008
resource "aws_security_group" "webtraffic" {
  name = "Allow HTTPS"
  description = "Webtraffic"

  dynamic "ingress" {
    iterator = port
    for_each = var.ingress_rules
    content {
      from_port = port.value
      protocol  = "TCP"
      to_port   = port.value
      cidr_blocks = ["0.0.0.0/0"]
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
