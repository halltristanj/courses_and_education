variable "serverNames" {
  type = list(string)

}

resource "aws_instance" "db" {
  ami           = "ami-0742b4e673072066f"
  instance_type = "t2.micro"
  tags = {
    Name = var.serverNames[count.index]
  }
  count = length(var.serverNames)
}

output "private_ip" {
  value = aws_instance.db.*.private_ip
}
