resource "aws_instance" "web" {
  ami           = "ami-0742b4e673072066f"
  instance_type = "t2.micro"
  tags = {
    Name = "Web EC2"
  }
  security_groups = [module.sg.sg_name]

  user_data = file("./web/server-script.sh")
}

module "eip" {
  source = "../eip"
  ec2_instance = aws_instance.web.id
}

module "sg" {
  source = "../sg"
}

output "instance_id" {
  value = aws_instance.web.id
}

output "pub_ip" {
  value = module.eip.public_ip
}
