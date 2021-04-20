provider "aws" {
  region                  = "us-east-1"
  shared_credentials_file = pathexpand("~/.aws/credentials")
  profile                 = "thall-udemy-terraform"
}

// This needs to come up first
resource "aws_instance" "db" {
  ami = "ami-0742b4e673072066f"
  instance_type = "t2.micro"
}

// web server depends on db
resource "aws_instance" "web" {
  ami = "ami-0742b4e673072066f"
  instance_type = "t2.micro"
  depends_on = [aws_instance.db]
}
