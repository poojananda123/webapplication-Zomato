<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Checkout</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
        }

        .container {
            margin-top: 50px;
        }

        .form-check-label {
            font-weight: normal;
        }

        button[type="submit"] {
            width: 100%;
        }
    </style>
</head>
<body>
<form action="order">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <h2 class="mb-4">Checkout</h2>
                <form>
                    <div class="form-group">
                        <label for="address">Delivery Address</label>
                        <textarea class="form-control" id="address" rows="3" required></textarea>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="city">City</label>
                            <div class="dropdown">
                                <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownCity" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    Select City
                                </button>
                                <div class="dropdown-menu" aria-labelledby="dropdownCity">
                                    <!-- Replace with your city options -->
                                    <a class="dropdown-item" href="#">Bangalore</a>
                                    <a class="dropdown-item" href="#">Chennai</a>
                                    <a class="dropdown-item" href="#">Hyderabad</a>
                                </div>
                            </div>
                        </div>
                        <div class="form-group col-md-6">
                            <label for="zip">Zip Code</label>
                            <div class="dropdown">
                                <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownZip" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    Select Pin Code
                                </button>
                                <div class="dropdown-menu" aria-labelledby="dropdownZip">
                                    <!-- Replace with your pin code options -->
                                    <a class="dropdown-item" href="#">560021</a>
                                    <a class="dropdown-item" href="#">125647</a>
                                    <a class="dropdown-item" href="#">646425</a>
                                </div>
                            </div>
                        </div>
                    </div>
     
                </form>
                <hr class="my-4">
                <h4 class="mb-3">Payment Method</h4>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="paymentMethod" id="creditCard" value="creditCard" checked>
                    <label class="form-check-label" for="creditCard">
                        Credit Card
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="paymentMethod" id="cashOnDelivery" value="cashOnDelivery">
                    <label class="form-check-label" for="cashOnDelivery">
                        Cash on Delivery
                    </label>
                </div>
                 <p>Total Price: ${parameter}</p>
                 <form id="order" action="order" method="get">
            <input type="hidden" name="parameter" id="parameter" value=" ${parameter}">
                <a href="order">
                
                 <button type="submit" class="btn btn-primary">Place Order</button></a>
                 </form>
            </div>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </form>
    
</body>
</html>
