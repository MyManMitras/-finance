import React from 'react';
import Button from 'react-toolbox/lib/button/Button';
import Input from 'react-toolbox/lib/input/Input';
import Dropdown from 'react-toolbox/lib/dropdown/Dropdown';
import DatePicker from 'react-toolbox/lib/date_picker/DatePicker';
import AddressCreateCard from './addressCreateCard';

class PersonCreateCard extends React.Component {

    state = {
        roles: [], role: 'Admin',
        genders: [], gender: 'Male',
        firstName: '', lastName: '', dob: null,
        loginId: '', password: '', confirmPassword: '', emailId: '',
        phone: '', firmId: ''
    };
    mapValues = (value) => {
        return {
            value: value,
            label: value
        };
    };

    componentDidMount() {
        fetch('/finance/v1/person/creation/details', {
            accept: 'application/json',
            credentials: "same-origin",
            headers: { 'Content-Type': 'application/json' }
        }).then(response => {
            response.json().then(data => {
                this.setState({
                    roles: data.roles.map(this.mapValues),
                    genders: data.genders.map(this.mapValues)
                });
            });
        }, error => {
            console.log('error: ' + error);
        });
    };

    handleChange = (field, value) => {
        this.setState({ ...this.state, [field]: value });
    };

    createPerson = () => {
        var person = {
            "loginID": this.state.loginId, "password": this.state.password, "firstName": this.state.firstName,
            "lastName": this.state.lastName, "dob": this.state.dob ? this.state.dob.getTime() : null, "gender": this.state.gender,
            "emailId": this.state.emailId, "phoneNo": this.state.phone, "role": this.state.role, "firmId": this.state.firmId,
            "address": {
                "line1": this.address.state.line1, "line2": this.address.state.line2, "city": this.address.state.city,
                "state": this.address.state.state, "pincode": this.address.state.pincode, "landMark": this.address.state.landmark
            }
        };

        fetch('/finance/v1/person', {
            method: 'POST',
            dataType: 'json',
            body: JSON.stringify(person),
            credentials: "same-origin",
            headers: {
                'Content-Type': 'application/json',
                'accept': 'application/json',
            }
        }).then(response => {
            response.json().then(data => {
                console.log('success');
            });
        }, error => {
            console.log('error: ' + error);
        });

    };

    render() {
        return (
            <section>
                <header>
                    <h3>{this.props.type || 'Person'} Creation</h3>
                </header>
                <section className="section-content">
                    <h5>{this.props.type || 'Person'} Details</h5>
                    <div className="row">
                        <div className="col-lg-3 col-sm-12 col-md-6">
                            <Input type='text' label='First Name' onChange={this.handleChange.bind(this, 'firstName')}
                                required value={this.state.firstName} />
                        </div>
                        <div className="col-lg-3 col-sm-12 col-md-6">
                            <Input type='text' label='Last Name' onChange={this.handleChange.bind(this, 'lastName')}
                                value={this.state.lastName} />
                        </div>
                        <div className="col-lg-3 col-sm-12 col-md-6">
                            <DatePicker label='Date of Birth' value={this.state.dob}
                                onChange={this.handleChange.bind(this, 'dob')} />
                        </div>
                        <div className="col-lg-3 col-sm-12 col-md-6">
                            <Dropdown auto source={this.state.genders} label='Gender'
                                value={this.state.gender} onChange={this.handleChange.bind(this, 'gender')} />
                        </div>
                        <div className="col-lg-3 col-sm-12 col-md-6">
                            <Input type='text' label='Login Id' onChange={this.handleChange.bind(this, 'loginId')}
                                maxLength={9} hint='Choose a unique firm Id' required value={this.state.loginId} />
                        </div>
                        <div className="col-lg-3 col-sm-12 col-md-6">
                            <Input type='password' label='Password' onChange={this.handleChange.bind(this, 'password')}
                                maxLength={9} hint='Choose a unique firm Id' required value={this.state.password} />
                        </div>
                        <div className="col-lg-3 col-sm-12 col-md-6">
                            <Input type='password' label='Confirm Password' onChange={this.handleChange.bind(this, 'confirmPassword')}
                                maxLength={9} hint='Choose a unique firm Id' required value={this.state.confirmPassword} />
                        </div>
                        <div className="col-lg-3 col-sm-12 col-md-6">
                            <Input type='email' label='Email Id' onChange={this.handleChange.bind(this, 'emailId')}
                                value={this.state.emailId} />
                        </div>
                        <div className="col-lg-3 col-sm-12 col-md-6">
                            <Input type='number' label='Phone Number' onChange={this.handleChange.bind(this, 'phone')}
                                maxLength={10} value={this.state.phone} />
                        </div>
                        <div className="col-lg-3 col-sm-12 col-md-6">
                            <Dropdown auto source={this.state.roles} label='Role'
                                value={this.state.role} onChange={this.handleChange.bind(this, 'role')} />
                        </div>
                        {(function () {
                            if (this.props.type !== 'Admin') {
                                return (<div className="col-lg-3 col-sm-12 col-md-6">
                                    <Input type='text' label='Firm Id' maxLength={9} onChange={this.handleChange.bind(this, 'firmId')}
                                        value={this.state.firmId} />
                                </div>)
                            }
                            return null;
                        }).bind(this)()
                        }
                    </div>
                </section>
                <AddressCreateCard ref={(address) => { this.address = address; }} />
                <section>
                    <div className="row">
                        <div className="col-lg-12 col-sm-12 col-md-12">
                            <Button raised primary label="Submit" onClick={this.createPerson.bind(this)}
                                style={{ margin: '10px', float: 'right' }} />
                            <Button raised label="Cancel" style={{ margin: '10px', float: 'right' }} />
                        </div>
                    </div>
                </section>
            </section>
        );
    };
}

export default PersonCreateCard;