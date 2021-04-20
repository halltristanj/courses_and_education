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

  ingress {
    from_port = 443
    protocol  = "TCP"
    to_port   = 443
    cidr_blocks = ["0.0.0.0/0"]
  }

  egress {
    from_port = 443
    protocol  = "TCP"
    to_port   = 443
    cidr_blocks = ["0.0.0.0/0"]
  }
}
