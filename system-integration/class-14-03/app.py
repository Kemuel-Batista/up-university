from flask import Flask, request, jsonify
import mysql.connector

app = Flask(__name__)

NOT_FOUND = 404
SUCCESS = 200

config = {
  "user": "root",
  "password": "positivo",
  "host": "localhost",
  "database": "system-integration"
}

@app.route("/")
def hello_world():
  return "<p>Hello, world</p>"

@app.route("/user", methods=["PUT"])
def update_user():
  id = request.args.get("id")

  if id is None:
    return __stardand_message_return("insert id of valid user", NOT_FOUND)
  
  connection = mysql.connector.connect(**config)

  if not connection.is_connected():
    return __stardand_message_return("problem on deb", 500)

  cursor = connection.cursor()

  cursor.execute("SELECT * FROM user WHERE id = ", str(id))

  user = cursor.fetchone()

  if user is None:
    return __stardand_message_return(
      "this user does not exist on database, please inform a user that exist",
      NOT_FOUND
    )
  
  body = request.get_json()

  return __stardand_message_return("the update was done with success", SUCCESS)

def __stardand_message_return(message, httpCode):
  return jsonify({ "message": message }), httpCode

if __name__ == "__main__":
  app.run(port=3000, debug=True)