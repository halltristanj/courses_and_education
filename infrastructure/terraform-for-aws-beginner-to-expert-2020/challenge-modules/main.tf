provider "aws" {
  region                  = "us-east-1"
  shared_credentials_file = pathexpand("~/.aws/credentials")
  profile                 = "thall-udemy-terraform"
}

module "db" {
  source = "./db"
}

module "web" {
  source = "./web"
}

output "Web" {
  value = module.web.instance_id
}

output "PrivateIP" {
  value = module.db.private_ip
}

output "PublicIP" {
  value = module.web.pub_ip
}
