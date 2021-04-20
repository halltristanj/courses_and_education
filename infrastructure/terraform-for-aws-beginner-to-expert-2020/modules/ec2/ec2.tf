variable "ec2_name" {
  type = string
}

resource "aws_instance" "ec2" {
  ami           = "ami-0742b4e673072066f"
  instance_type = "t2.micro"
  tags = {
    Name = var.ec2_name
  }
}

output "instance_id" {
  value = aws_instance.ec2.id
}
