variable "ingress_rules" {
  type = list(number)
  default = [80, 443]
}

variable "egress_rules" {
  type = list(number)
  default = [80, 443]
}
