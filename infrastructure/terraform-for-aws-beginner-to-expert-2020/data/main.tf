provider "aws" {
  region                  = "us-east-1"
  shared_credentials_file = pathexpand("~/.aws/credentials")
  profile                 = "thall-udemy-terraform"
}

resource "aws_instance" "ec2" {
  ami           = "ami-0742b4e673072066f"
  instance_type = "t2.micro"
  tags = {
    Name = "DB Server"
  }
}

resource "aws_eip" "elasticip" {
  instance = aws_instance.ec2.id
}

output "EIP" {
  value = aws_eip.elasticip.public_ip
}

data "aws_instance" "dbsearch" {
  filter {
    name   = "tag:Name"
    values = ["DB Server"]
  }
  depends_on = [aws_instance.ec2]
}

output "dbservers" {
  value = data.aws_instance.dbsearch.availability_zone
}
