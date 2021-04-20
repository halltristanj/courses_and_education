output "sg_name" {
  value = aws_security_group.web_traffic.name
}

resource "aws_security_group" "web_traffic" {
  name = "SG for WebServer"

  dynamic "ingress" {
    iterator = port
    for_each = var.ingress_rules
    content {
      from_port   = port.value
      protocol    = "TCP"
      to_port     = port.value
      cidr_blocks = [
        "0.0.0.0/0"] #tfsec:ignore:AWS009
    }
  }

  dynamic "egress" {
    iterator = port
    for_each = var.egress_rules
    content {
      from_port   = port.value
      protocol    = "TCP"
      to_port     = port.value
      cidr_blocks = [
        "0.0.0.0/0"] #tfsec:ignore:AWS009
    }
  }
}
