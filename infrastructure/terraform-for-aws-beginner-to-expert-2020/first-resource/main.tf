provider "aws" {
  region = "us-east-1"
  shared_credentials_file = pathexpand("~/.aws/credentials")
  profile = "thall-udemy-terraform"
}

resource "aws_vpc" "myvpc" {
  cidr_block = "10.0.0.0/16"
}
