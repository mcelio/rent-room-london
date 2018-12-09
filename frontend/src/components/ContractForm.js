import React, { Component } from 'react';
import axios from "axios";
import 'bootstrap/dist/css/bootstrap.css';
import { Button, Form, FormGroup, Label, Input, FormText } from 'reactstrap';

class ContractForm extends Component {

    // Initializing important variables
    constructor(props) {
       super(props);
       this.save = this.save.bind(this);
       this.handleStartDateChange = this.handleStartDateChange.bind(this);
       this.handleEndDateChange = this.handleEndDateChange.bind(this);
       this.handleTypeChange = this.handleTypeChange.bind(this);
       this.handleAdvanceNumberChange = this.handleAdvanceNumberChange.bind(this);
       this.handleAdvanceChange = this.handleAdvanceChange.bind(this);
       this.handleDepositNumberChange = this.handleDepositNumberChange.bind(this);
       this.handleDepositChange = this.handleDepositChange.bind(this);
       this.handleAmountChange = this.handleAmountChange.bind(this);
       this.handlePersonChange = this.handlePersonChange.bind(this);
       this.handlePropertyChange = this.handlePropertyChange.bind(this);
       this.state = {
           id: "",
           startDate: "",
           endDate: "",
           type: "",
           advanceNumber: "",
           advance: "",
           depositNumber: "",
           deposit: "",
           amount: "",
           person: "",
           property: ""
       };
     }

     handleStartDateChange(e) {
        this.setState({startDate: e.target.value});
     }

     handleEndDateChange(e) {
        this.setState({endDate: e.target.value});
     }

     handleTypeChange(e) {
        this.setState({type: e.target.value});
     }

     handleAdvanceNumberChange(e) {
        this.setState({advanceNumber: e.target.value});
     }

     handleAdvanceChange(e) {
        this.setState({advance: e.target.value});
     }

     handleDepositNumberChange(e) {
        this.setState({depositNumber: e.target.value});
     }

     handleDepositChange(e) {
        this.setState({deposit: e.target.value});
     }

     handleAmountChange(e) {
        this.setState({amount: e.target.value});
     }

     handlePersonChange(e) {
        this.setState({person: e.target.value});
     }

     handlePropertyChange(e) {
        this.setState({property: e.target.value});
     }

    save(event) {
        event.preventDefault();
        console.log("saving contract form");
        const authStr = localStorage.getItem('id_token');
        const headers = {
            "Accept": "application/json",
            "Content-Type": "application/json",
            "Authorization": authStr,
            "Access-Control-Request-Origin" : "*",
            "Access-Control-Allow-Credentials":"true",
            "withCredentials" : true,
        }

       const contract = {
           "startDate": this.state.startDate,
           "endDate": this.state.endDate,
           "type": this.state.type,
           "advanceNumber": this.state.advanceNumber,
           "advance": this.state.advance,
           "depositNumber": this.state.depositNumber,
           "deposit": this.state.deposit,
           "amount": this.state.amount,
           "person": this.state.person,
           "property": this.state.property
       }

        axios({
            method: "post",
            url: "http://localhost:8081/contract",
            withCredentials: true,
            data: contract,
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
                  <Label for="id">Id</Label>
                  <Input type="text" name="id" id="id" onChange={this.handleIdChange} placeholder="Id " />
                </FormGroup>

                <FormGroup>
                  <Label for="startDate">Start Date</Label>
                  <Input type="text" name="startDate" id="startDate" onChange={this.handleStartDateChange} placeholder="Start Date " />
                </FormGroup>

                <FormGroup>
                  <Label for="endDate">End Date</Label>
                  <Input type="text" name="endDate" id="endDate" onChange={this.handleEndDateChange} placeholder="End Date " />
                </FormGroup>

                <FormGroup>
                  <Label for="type">Payment Type</Label>
                  <Input type="text" name="type" id="type" onChange={this.handleTypeChange} placeholder="Payment Type " />
                </FormGroup>

                <FormGroup>
                  <Label for="advanceNumber">Advance Number</Label>
                  <Input type="text" name="advanceNumber" id="advanceNumber" onChange={this.handleAdvanceNumberChange} placeholder="Advance Number" />
                </FormGroup>

                <FormGroup>
                  <Label for="advance">Advance</Label>
                  <Input type="text" name="advance" id="advance" onChange={this.handleAdvanceChange} placeholder="Advance" />
                </FormGroup>

                <FormGroup>
                  <Label for="depositNumber">Deposit Number</Label>
                  <Input type="text" name="depositNumber" id="depositNumber" onChange={this.handleDepositNumberChange} placeholder="Deposit Number " />
                </FormGroup>

                <FormGroup>
                  <Label for="deposit">Deposit</Label>
                  <Input type="text" name="deposit" id="deposit" onChange={this.handleDepositChange} placeholder="Deposit " />
                </FormGroup>

                <FormGroup>
                  <Label for="amount">Amount</Label>
                  <Input type="text" name="amount" id="amount" onChange={this.handleAmountChange} placeholder="Amount " />
                </FormGroup>

                <FormGroup>
                  <Label for="person">Person</Label>
                  <Input type="text" name="person" id="person" onChange={this.handlePersonChange} placeholder="Person " />
                </FormGroup>

                <FormGroup>
                  <Label for="property">Property</Label>
                  <Input type="text" name="property" id="property" onChange={this.handlePropertyChange} placeholder="Property " />
                </FormGroup>

                <Button onClick={this.save}>Save</Button>
              </Form>
            );
        }
}

export default ContractForm;
