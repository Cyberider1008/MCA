import json
from flask import Flask, render_template, request
import os
import aiml
from autocorrect import spell
import requests


import urllib.request

app = Flask(__name__)

BRAIN_FILE="./pretrained_model/aiml_pretrained_model.dump"
k = aiml.Kernel()

if os.path.exists(BRAIN_FILE):
    print("Loading from brain file: " + BRAIN_FILE)
    k.loadBrain(BRAIN_FILE)
else:
    print("Parsing aiml files")
    k.bootstrap(learnFiles="./pretrained_model/learningFileList.aiml", commands="load aiml")
    print("Saving brain file: " + BRAIN_FILE)
    k.saveBrain(BRAIN_FILE)


@app.route("/")
def home():
    return render_template("home.html")


@app.route("/get")
def get_bot_response():
    
    apiToken = "6019159291:AAF7liqkleBMxuPfYpSjXaB-mW60LwB9-MQ"
    chatId = "932338125"

    # url = urllib.request.urlopen(f"https://api.telegram.org/bot{apiToken}/getUpdates?chat_id={chatId}&offset=-1").read()
    url = f"https://api.telegram.org/bot{apiToken}/getUpdates?chat_id={chatId}&offset=-1"
  
    list_of_data = requests.post(url).json()

    print("-------------"+str(list_of_data['result'][0]["message"]["text"]))

    update_id  = list_of_data['result'][0]["update_id"]


    query = request.args.get('msg')
    print("---------------",query)
    
    query = [spell(w) for w in (query.split())]

    
    question = " ".join(query)
    print("-----------q",question)
    response = k.respond(question)
    if response:
        print("---------------",response)
        return (str(response))
    else:
        return (str(":)"))


if __name__ == "__main__":
    # app.run()
    app.run(host='0.0.0.0', port='5000')


