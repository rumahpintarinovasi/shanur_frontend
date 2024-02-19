# Use the official Node.js v20 image as the base image
FROM node:20 AS build

# Set the working directory in the container
WORKDIR /app

# Copy the rest of the application code to the working directory
COPY . .

# Install dependencies
RUN npm install

# Expose port 3000
EXPOSE 3000

# Set the command to run the app
CMD ["npm", "run", "dev"]