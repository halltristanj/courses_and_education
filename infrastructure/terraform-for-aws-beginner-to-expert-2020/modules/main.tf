provider "aws" {
  region                  = "us-east-1"
  shared_credentials_file = pathexpand("~/.aws/credentials")
  profile                 = "thall-udemy-terraform"
}

module "ec2_module" {
  source = "./ec2"
  ec2_name = "Name from Module"
}

output "module_output" {
  value = module.ec2_module.instance_id
}
