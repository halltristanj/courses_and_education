variable "vpc_name" {
  type = string
  default = "TerraformVPC"
}

variable "cidr_range" {
  type = string
  default = "192.168.0.0/24"
}
