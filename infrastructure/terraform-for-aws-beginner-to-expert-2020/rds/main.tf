provider "aws" {
  region                  = "us-east-1"
  shared_credentials_file = pathexpand("~/.aws/credentials")
  profile                 = "thall-udemy-terraform"
}

variable "password" {
  type = string
}

variable "username" {
  type = string
}

resource "aws_db_instance" "rds" {
  name = "Udemy RDS"
  identifier = "udemy-rds"
  instance_class = "db.t2.micro"
  engine = "postgres"
  engine_version = "10.2.21"
  username = var.username
  password = var.password
  port = 3306
  allocated_storage = 20
  skip_final_snapshot = true
  storage_encrypted = true
}
