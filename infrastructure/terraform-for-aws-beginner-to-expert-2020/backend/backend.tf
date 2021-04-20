variable "aws_access_key" {
  type = string
}

variable "aws_secret_key" {
  type = string
}

terraform {
  // Create tfstate somewhere else
  backend "s3" {
    bucket     = "thall-udemy-terraform"
    key        = "terraform/tfstate.tfstate"
    region     = "us-east-1"
    access_key = var.aws_access_key
    secret_key = var.aws_secret_key
  }
}
