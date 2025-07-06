# EAI Middleware for Inventory Management
 
This is a demo middleware built using Apache Camel to integrate an inventory system, order processor, and e-commerce frontend.
 
## Features
- Receives order from e-commerce
- Sends order to processing system
- Updates stock levels
- Shares order status back to customers
 
## Technologies
- Java 11+
- Apache Camel 3.22
- Maven
- Hosted on Replit
- Version-controlled via GitHub
 
## How to Run
1. Clone this repo into Replit (see steps below)
2. Click "Run"
3. Use Postman or cURL to test these endpoints:
   - `POST /order`
   - `POST /inventory`
   - `POST /order-status`
 
