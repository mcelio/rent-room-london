import React, { Component } from 'react';
import axios from "axios";
import 'bootstrap/dist/css/bootstrap.css';
import { Button, Form, FormGroup, Label, Input, FormText } from 'reactstrap';

class PaymentForm extends Component {

    // Initializing important variables
    constructor(props) {
       super(props);
       this.save = this.save.bind(this);
       this.handleDateChange = this.handleDateChange.bind(this);
       this.handleChargeTypeChange = this.handleChargeTypeChange.bind(this);
       this.handleContractChange = this.handleContractChange.bind(this);
       this.handleDescriptionChange = this.handleDescriptionChange.bind(this);
       this.handleAmountChange = this.handleAmountChange.bind(this);
       this.state = {
           id: "",
           date: "",
           chargeType: "",
           contract: "",
           description: "",
           amount: ""
       };
     }

     handleDateChange(e) {
        this.setState({date: e.target.value});
     }

     handleChargeTypeChange(e) {
        this.setState({chargeType: e.target.value});
     }

     handleDescriptionChange(e) {
        this.setState({description: e.target.value});
     }

     handleAmountChange(e) {
        this.setState({amount: e.target.value});
     }

     handleContractChange(e) {
        this.setState({contract: e.target.value});
     }

    save(event) {
        event.preventDefault();
        console.log("saving payment form");
        const authStr = localStorage.getItem('id_token');
        const headers = {
            "Accept": "application/json",
            "Content-Type": "application/json",
            "Authorization": authStr,
            "Access-Control-Request-Origin" : "*",
            "Access-Control-Allow-Credentials":"true",
            "withCredentials" : true,
        }

       const payment = {
           "date": this.state.date,
           "chargeType": this.state.chargeType,
           "description": this.state.description,
           "amount": this.state.amount,
           "contract": this.state.contract
       }

        axios({
            method: "post",
            url: "http://localhost:8081/payment",
            withCredentials: true,
            data: payment,
            headers
          }).then(function (response) {
             return Promise.resolve(response);
          }).catch(function (error) {
             console.log(error);
          });
    }

    render() {
            return (
              <Form>
                <FormGroup>
                  <Label for="date">Date</Label>
                  <Input type="text" name="date" id="date" onChange={this.handleDateChange} placeholder="Date " />
                </FormGroup>

                <FormGroup>
                  <Label for="chargeType">Charge Type</Label>
                  <Input type="text" name="chargeType" id="chargeType" onChange={this.handleChargeTypeChange} placeholder="ChargeType " />
                </FormGroup>

                <FormGroup>
                  <Label for="Description">Description</Label>
                  <Input type="text" name="description" id="description" onChange={this.handleDescriptionChange} placeholder="Description " />
                </FormGroup>

                <FormGroup>
                  <Label for="amount">Amount</Label>
                  <Input type="text" name="amount" id="amount" onChange={this.handleAmountChange} placeholder="Amount " />
                </FormGroup>

                <FormGroup>
                  <Label for="contract">Contract</Label>
                  <Input type="text" name="contract" id="contract" onChange={this.handleContractChange} placeholder="Contract " />
                </FormGroup>

                <Button onClick={this.save}>Save</Button>
              </Form>
            );
        }
}

export default PaymentForm;
