#!/usr/bin/env python

from flask import Flask
app = Flask(__name__)

@app.route('/hi')
def hello_world():
    return 'Hello World!'

if __name__ == '__main__':
    print('Running from 5000')
    app.run(host='0.0.0.0', port=5000)
