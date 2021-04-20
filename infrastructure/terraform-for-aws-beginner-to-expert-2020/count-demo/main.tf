provider "aws" {
  region                  = "us-east-1"
  shared_credentials_file = pathexpand("~/.aws/credentials")
  profile                 = "thall-udemy-terraform"
}

module "db" {
  source = "./db"
  serverNames = ["foo", "bar", "baz"]
}

output "private_ips" {
  value = module.db.private_ip
}
