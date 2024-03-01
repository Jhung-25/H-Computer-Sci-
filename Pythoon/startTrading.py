from alpaca.trading.client import TradingClient
from alpaca.trading.requests import GetAssetsRequest, MarketOrderRequest
from alpaca.trading.enums import AssetClass, OrderSide, TimeInForce
from alpaca.trading.stream import TradingStream
# from openai import OpenAI
import openai
import requests
import json
import os

# openai_api_key = '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'
openai.api_key = "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"
# if openai_api_key is None:
#     raise ValueError("OpenAI API key is not set in environment variables.")

url = "https://api.openai.com/v1/chat/completions"

headers = {
    "Content-Type": "application/json",
    "Authorization": f"Bearer {openai.api_key}"
}

data = {
    "model": "gpt-3.5-turbo",
    "messages": [
        {
            "role": "system",
            "content": "You are a helpful assistant."
        },
        {
            "role": "user",
            "content": "Hello!"
        }
    ]
}

response = requests.post(url, headers=headers, json=data)

# Check if the request was successful
if response.status_code == 200:
    print("Response from OpenAI:", response.json())
    print('\n')
    print(response.json()['choices'][0]['message']['content'])
else:
    print("Error:", response.status_code, response.text)

# import config
apikey="PKA6EJ6Q6Q23CE0CO0HP"
apiSecretKey="IyUSB2F7Hjyd4ec6Hevc9sU76EaOvi0w4AeVaTIb"
client= TradingClient(apikey, apiSecretKey, paper=True)
account = dict(client.get_account())

for k,v in account.items():
    print(f"{k:30}{v}")

order_details = MarketOrderRequest()(
    symbol="SPY",
    qty=10,
    side=OrderSide.BUY,
    time_in_force = TimeInForce.Day

)
order= client.submit_order(order_data= order_details)

trades= TradingStream(apikey,apiSecretKey, paper=True)

async def trade_status(data):
    print(data)