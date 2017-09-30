import React from 'react';
import Button from 'react-toolbox/lib/button/Button';
import Input from 'react-toolbox/lib/input/Input';
import Table from './table/table';
import _ from 'lodash';

const usersTableHeader = [
    {label: "Name", key: "firstName"},
    {label: "Gender", key: "gender"},
    {label: "DoB", key: "dob", type: Date},
    {label: "Email Id", key: "emailId"},
    {label: "Role", key: "role"},
];
class LoanCreateCard extends React.Component {
    state = {
        borrower: '', guranteer: '', persons: null
    };

    handleChange = (field, value) => {
        this.setState({ ...this.state, [field]: value });
    };

    getLoanDetailsForm() {
        return (
            <section className="section-content">
                <h5>Loan Details</h5>
                <div className="row">
                    <div className="col-lg-4 col-sm-12 col-md-6">
                        <Input type='text' label='Borrower' />
                    </div>
                    <div className="col-lg-4 col-sm-12 col-md-6">
                        <Input type='text' label='Guranteer' />
                    </div>
                    <div className="col-lg-4 col-sm-12 col-md-6">
                        <Input type='text' label='Remarks' />
                    </div>
                    <div className="col-lg-3 col-sm-12 col-md-6">
                        <Input type='text' label='Principle' />
                    </div>
                    <div className="col-lg-3 col-sm-12 col-md-6">
                        <Input type='text' label='Rate' />
                    </div>
                    <div className="col-lg-3 col-sm-12 col-md-6">
                        <Input type='text' label='Collection Frequency' />
                    </div>
                    <div className="col-lg-3 col-sm-12 col-md-6">
                        <Input type='text' label='Tenure' />
                    </div>
                </div>
            </section>);
    };

    chooseBorrower(person) {
        console.log(person);
    };

    filterPersons(filterText) {
        if(filterText) {
            var filterPersons = [];
            _.forEach(this.state.persons, function(person) {
                if(_.indexOf(person.emailId, filterText) > -1){
                    filterPersons.push(person);
                }
            });
            return filterPersons;
        } else {
            return this.state.persons;
        }
    };

    showBorrowersList() {
        if(!this.state.borrower && this.state.persons) {
            return (
            <div className="col-lg-12 col-sm-12 col-md-12">
                <Table headers={usersTableHeader} data={this.filterPersons(this.state.borrower)} click={this.chooseBorrower.bind(this)}/>
            </div>);
        }else {
            return null;
        }
    };

    chooseBorrowerAndGuranteer() {
        return(
            <section className="section-content">
                <h5>Choose Borrower</h5>
                <div className="row">
                    <div className="col-lg-4 col-sm-12 col-md-6">
                        <Input type='text' label='Borrower' onChange={this.handleChange.bind(this, 'borrower')} 
                            value = {this.state.borrower}/>
                    </div>
                    <div className="col-lg-4 col-sm-12 col-md-6">
                        <Button label='Create New Borrower' raised/>
                    </div>
                    {this.showBorrowersList()}
                </div>
                <h5>Choose Guranteer</h5>
                <div className="row">
                    <div className="col-lg-4 col-sm-12 col-md-6">
                        <Input type='text' label='Guranteer' />
                    </div>
                    <div className="col-lg-4 col-sm-12 col-md-6">
                        <Button label='Create New Guranteer' raised/>
                    </div>
                </div>
            </section>
        );
    };

    collectDetails() {
        if (this.state.borrower && this.state.guranteer)
            return this.getLoanDetailsForm();
        else 
            return this.chooseBorrowerAndGuranteer();
    };

    loadLoanablePersons() {
        fetch('/finance/v1/loan/persons', {
            accept: 'application/json',
            credentials: "same-origin",
            headers: { 'Content-Type': 'application/json' }
        }).then(response => {
            response.json().then(data => {
                this.setState({
                    persons: data
                });
            });
        }, error => {
            console.log('error: ' + error);
        });
    };

    componentWillMount() {
        this.loadLoanablePersons();
    };

    render() {
        return (
            <section>
                <header>
                    <h3>Lend Loan</h3>
                </header>
                {this.collectDetails()}
            </section>
        );
    }
}

export default LoanCreateCard;