OAUTH2 and Wallet
===


Get Access Token :

curl -H"Authorization: Basic Base64{AcmeClient+AcmePassword}" http://localhost:9999/oauth/token -d grant_type=password 
-d username=josete -d password=secret -d client_id=AcmeClient


Use Access Token :

curl -H"Authorization: Bearer {access_token}" http://localhost:5000/wallet/1
