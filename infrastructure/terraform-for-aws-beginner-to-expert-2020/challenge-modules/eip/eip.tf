variable "ec2_instance" {
  type = string
  description = "The ID of the AWS instance to link to this EIP."
}

resource "aws_eip" "web_ip" {
  instance = var.ec2_instance
}

output "public_ip" {
  value = aws_eip.web_ip.private_ip
}
