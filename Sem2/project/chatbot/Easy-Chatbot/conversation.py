import os
import aiml
from autocorrect import spell
import requests
import mysql.connector


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

limit = 0 
apiToken = "6019159291:AAF7liqkleBMxuPfYpSjXaB-mW60LwB9-MQ"
chatId = "932338125"


try:
    mydb = mysql.connector.connect(
    host="localhost",
    user="root",
    password="root",
    database="chatbot"
    )
    mycursor = mydb.cursor()

    while True:
        
        url = f"https://api.telegram.org/bot{apiToken}/getUpdates?chat_id={chatId}&offset=-1"
    
        # converting JSON data to a dictionary
        list_of_data = requests.post(url).json()
        # print("______________before update")
        update_id  = list_of_data['result'][0]["update_id"]
        # print("______________up", update_id)

        if(limit <=update_id):
            # print("______________ after update")
            print("User >"+str(list_of_data['result'][0]["message"]["text"]))
            query = str(list_of_data['result'][0]["message"]["text"])
            
            user_id = int(list_of_data['result'][0]["message"]["from"]["id"])
            first_name = str(list_of_data['result'][0]["message"]["from"]["first_name"])
            username = str(list_of_data['result'][0]["message"]["from"]["username"])
            
            
            user_sql = "INSERT INTO user (user_id, first_name, username) VALUES (%s, %s, %s)"
            val1 =(user_id, first_name, username)
            
            try:
                mycursor.execute(user_sql, val1)

                mydb.commit()
                # mydb.close()

            except (mysql.connector.IntegrityError, mysql.connector.DataError) as err:
                print("DataError or IntegrityError")
                print(err)

            except mysql.connector.ProgrammingError as err:
                print("Programming Error")
                print(err)

            except mysql.connector.Error as err:
                print(err)
                    
            query = [spell(w) for w in (query.split())]

            chat_desc = ' '.join(map(str, query))

            question = " ".join(query)
            response = k.respond(question)
            
            if response:
                print("-------------------------------------------------------")


                chat_sql = "INSERT INTO chat_fromuser(update_id, chat_describe, user_id) VALUES(%s, %s, %s)"
                val2 =(update_id, chat_desc, user_id)

                try:
                    mycursor.execute(chat_sql, val2)

                    mydb.commit()
                    

                except (mysql.connector.IntegrityError, mysql.connector.DataError) as err:
                    print("DataError or IntegrityError")
                    print(err)

                except mysql.connector.ProgrammingError as err:
                    print("Programming Error")
                    print(err)

                except mysql.connector.Error as err:
                    print(err)
                
                

                bot_sql = "INSERT INTO reply_frombot (reply_describe, update_id) VALUES (%s, %s)"
                val1 =(response, update_id)
                
                try:
                    mycursor.execute(bot_sql, val1)

                    mydb.commit()

                except (mysql.connector.IntegrityError, mysql.connector.DataError) as err:
                    print("DataError or IntegrityError")
                    print(err)

                except mysql.connector.ProgrammingError as err:
                    print("Programming Error")
                    print(err)

                except mysql.connector.Error as err:
                    print(err)
                
                

                url = f'https://api.telegram.org/bot{apiToken}/sendMessage'
                data = {'chat_id': {chatId}, 'text': response}
                requests.post(url, data).json()


                print("bot > ", response)
            else:
                print("bot > :) ", )
            
            limit = update_id + 1
        

except mysql.connector.Error as err:
    print(err)

finally:
    mydb.close()
