provider "aws" {
  region                  = "us-east-1"
  shared_credentials_file = pathexpand("~/.aws/credentials")
  profile                 = "thall-udemy-terraform"
}

resource "aws_iam_user" "my_user" {
  name = "T-Weezy"
}

resource "aws_iam_policy" "custom_policy" {
  name   = "MyCustomPolicy"
  policy = <<EOF
{
        "Version": "2012-10-17",
        "Statement": [
            {
                "Sid": "VisualEditor0",
                "Effect": "Allow",
                "Action": [
                    "ec2:DeleteManagedPrefixList",
                    "ec2:AuthorizeSecurityGroupIngress",
                    "ec2:ReplaceRouteTableAssociation",
                    "ec2:ModifyManagedPrefixList",
                    "ec2:DeleteVpcEndpoints",
                    "ec2:ResetInstanceAttribute",
                    "ec2:RejectTransitGatewayMulticastDomainAssociations",
                    "ec2:ResetEbsDefaultKmsKeyId",
                    "ec2:AttachInternetGateway",
                    "ec2:ReportInstanceStatus",
                    "ec2:ModifyVpnConnectionOptions",
                    "ec2:DeleteVpnGateway",
                    "ec2:CreateRoute",
                    "ec2:ResetFpgaImageAttribute"
                ],
                "Resource": "*"
            }
        ]
    }
    EOF
}

resource "aws_iam_policy_attachment" "policy_bind" {
  name       = "attachment"
  policy_arn = aws_iam_policy.custom_policy.arn
  users = [aws_iam_user.my_user.name]
}
