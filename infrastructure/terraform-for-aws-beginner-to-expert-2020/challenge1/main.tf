provider "aws" {
  region = "us-east-1"
  shared_credentials_file = pathexpand("~/.aws/credentials")
  profile = "thall-udemy-terraform"
}

resource "aws_vpc" "challenge1" {
  cidr_block = var.cidr_range
  tags = {
    Name = var.vpc_name
  }
}
