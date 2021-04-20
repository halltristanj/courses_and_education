variable "ingress_rules" {
  type = list(number)
  default = [80, 443]
}

variable "egress_rules" {
  type = list(number)
  default = [80, 443, 25, 3006, 53, 8080]
}
