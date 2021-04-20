provider "aws" {
  region = "us-east-1"
  shared_credentials_file = pathexpand("~/.aws/credentials")
  profile = "thall-udemy-terraform"
}

variable "vpc_name" {
  type = string
  default = "udemy-terraform-course"
}

variable "ssh_port" {
  type = number
  default = 22
}

variable "enabled" {
  default = true
}

variable "my_list" {
  type = list(string)
  default = ["Value1", "Value2"]
}

variable "my_map" {
  type = map(any)
  default = {
    Key1 = "Value1"
    Key2 = "Value2"
  }
}

variable "input_name" {
  type = string
  description = "Set the name of the VPC"
}

resource "aws_vpc" "myvpc" {
  cidr_block = "10.0.0.0/16"

  tags = {
    Name = var.input_name
  }
}

output "vpcid" {
  value = aws_vpc.myvpc.id
}

variable "mytuple" {
  type = tuple([string, number, string])
  default = ["cat", 1, "dog"]
}

variable "myobject" {
  type = object({name = string, port = list(number)})
  default = {
    name = "foo"
    port = [22, 24]
  }
}
