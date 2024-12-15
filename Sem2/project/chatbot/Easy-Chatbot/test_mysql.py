import mysql.connector

mydb = mysql.connector.connect(
  host="localhost",
  user="root",
  password="root",
  database="chatbot"
)

mycursor = mydb.cursor()

sql = "INSERT INTO user (user_id, first_name, username) VALUES (%s, %s, %s)"
val = (2,"John", "Highway 21")
mycursor.execute(sql, val)

mydb.commit()

print(mycursor.rowcount, "record inserted.")