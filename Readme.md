OAUTH2 and Wallet
===


Get Access Token :

`curl -H"Authorization: Basic Base64{AcmeClient+AcmePassword}" http://localhost:9999/oauth/token -d grant_type=password -d username=test -d password=secret -d client_id=AcmeClient`


Use Access Token :

`curl -H"Authorization: Bearer {access_token}" http://localhost:5000/wallet/1`

Get Token information

`curl -H"Authorization: Bearer {access_token}" http://localhost:5000/wallet/me`

Generate JKS Java KeyStore File

`keytool -genkeypair -alias mytest -keyalg RSA -keypass mypass -keystore mytest.jks -storepass mypass`

The command will generate a file called mytest.jks which contains our keys -the Public and Private keys.

Export Public Key

`keytool -list -rfc --keystore mytest.jks | openssl x509 -inform pem -pubkey`
