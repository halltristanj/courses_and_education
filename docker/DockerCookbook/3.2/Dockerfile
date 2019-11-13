FROM python:3.6.9-slim-stretch

RUN pip install flask

COPY hello.py /tmp/hello.py
COPY hello-different-port.py /tmp/hello-different-port.py
COPY run.sh /tmp/run.sh
RUN chmod +x /tmp/run.sh

EXPOSE 5000
EXPOSE 4000
EXPOSE 3000

#CMD ["python", "/tmp/hello.py", "&&", "python", "/tmp/hello-different-port.py"]
CMD /tmp/run.sh
