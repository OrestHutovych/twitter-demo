How to start project?

First you need run docker.

Write in terminal commands:
1. cd docker
2. docker-compose up -d

http://localhost:8081/api/v1/accounts/register [POST] - Create account
http://localhost:8081/api/v1/authentication/login [POST] - Login account
http://localhost:8081/api/v1/user_profile/register [POST] - Create user profile
http://localhost:8081/api/v1/tweets/add_tweet [POST] - Add tweet
http://localhost:8081/api/v1/tweets/edit_tweet [PUT] - Edit tweet
http://localhost:8081/api/v1/tweets/{tweet_id} [DELETE] - Delete tweet
http://localhost:8081/api/v1/tweets?page={number}&limit={number} [GET] - Find Tweets
http://localhost:8081/api/v1/subscription/subscribe [POST] - Subscribe to User Profile
http://localhost:8081/api/v1/subscription/unsubscribe [DELETE] - UnSubscribe from User Profile
http://localhost:8081/api/v1/subscription/followers [GET] - Get all followers

