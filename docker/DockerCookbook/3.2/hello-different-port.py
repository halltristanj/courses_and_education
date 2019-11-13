#!/usr/bin/env python

from flask import Flask
app = Flask(__name__)

@app.route('/hi')
def hello_world():
    return 'Hello World 4000!'

if __name__ == '__main__':
    print('running from 4000')
    app.run(host='0.0.0.0', port=4000)
