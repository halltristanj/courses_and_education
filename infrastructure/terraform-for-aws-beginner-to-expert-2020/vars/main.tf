provider "aws" {
  region                  = "us-east-1"
  shared_credentials_file = pathexpand("~/.aws/credentials")
  profile                 = "thall-udemy-terraform"
}

variable "n_servers" {
  type = number
  description = "The number of servers"
}


resource "aws_instance" "db" {
  ami           = "ami-0742b4e673072066f"
  instance_type = "t2.micro"
  count = var.n_servers
}

//output "private_ips" {
//  value = module.db.private_ip
//}
//
//output "private_ip" {
//  value = aws_instance.db.*.private_ip
//}
