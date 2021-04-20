//variable "ec2_name" {
//  type = string
//}

resource "aws_instance" "db" {
  ami           = "ami-0742b4e673072066f"
  instance_type = "t2.micro"
  tags = {
    Name = "DB Name"
  }
}

output "private_ip" {
  value = aws_instance.db.private_ip
}
