aws s3 mb s3://luongnv-code-sam-demo

#package cloudformation
aws cloudformation package --s3-bucket luongnv-code-sam-demo --template-file template.yaml --output-template-file gen/template-generated.yaml

#sam packge...
#deploy
aws cloudformation deploy --template-file gen/template-generated.yaml --stack-name hello-world-sam --capabilities CAPABILITY_IAM