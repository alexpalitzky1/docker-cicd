FROM node:4.6
WORKDIR /app
ADD . ./
RUN echo " this is a test "
RUN ls -ltrh
WORKDIR /app/basics
RUN npm install
EXPOSE 3000
CMD npm start
