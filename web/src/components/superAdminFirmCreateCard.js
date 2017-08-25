import React from 'react';
import Button from 'react-toolbox/lib/button/Button';
import Input from 'react-toolbox/lib/input/Input';
import Dropdown from 'react-toolbox/lib/dropdown/Dropdown';
import DatePicker from 'react-toolbox/lib/date_picker/DatePicker';
import AddressCreateCard from './addressCreateCard';
import _ from 'lodash';

class SuperAdminFirmCreateCard extends React.Component {

    state = {
        overview: {}, hint: '', firmTypes: [], services: [], admins: [],
        firmId: '', firmName: '', adminName: '', email: '', phone1: '', phone2: '', establishmentDate: null, licenseNumber: '',
        validTill: null, firmType: '', serviceType: '', bankName: '', branch: '', ifsCode: '', accountNumber: ''
    };

    constructor(props) {
        super(props);
        if (!_.isEmpty(props.firm))
            this.state = this.getStateFromProps(props.firm);
    };

    getStateFromProps = (firm) => {
        return {
            firmId: firm.firmId, firmName: firm.firmName, adminName: firm.adminName, email: firm.email, phone1: firm.phone1,
            phone2: firm.phone2, establishmentDate: firm.establishmentDate, licenseNumber: firm.licenseNumber, validTill: firm.validTill,
            firmType: firm.firmType, serviceType: firm.serviceType, bankName: firm.bankName, branch: firm.branch,
            ifsCode: firm.ifsCode, accountNumber: firm.accountNumber
        };
    };

    componentWillReceiveProps(nextProps) {
        if(nextProps.firm) this.setState(this.getStateFromProps(nextProps.firm));
    };
    mapValues = (value) => {
        return {
            value: value,
            label: value
        };
    };

    handleChange = (field, value) => {
        this.setState({ ...this.state, [field]: value });
    };

    componentWillMount() {
        fetch('/finance/v1/firm/creation/details', {
            accept: 'application/json', credentials: "same-origin", headers: { 'Content-Type': 'application/json' }
        })
            .then(response => {
                response.json()
                    .then(data => {
                        this.setState({
                            firmTypes: data.ownerships.map(this.mapValues),
                            services: data.orgTypes.map(this.mapValues),
                            admins: data.admins.map(this.mapValues)
                        });
                    });
            }, error => {
                console.log('error: ' + error);
            });
    };

    createFirm = () => {
        var firmDetails = {
            name: this.state.firmName, firmId: this.state.firmId, emailId: this.state.email, phone1: this.state.phone1,
            phone2: this.state.phone2, admin: _.last(this.state.adminName.split(' - ')), establishmentDate: this.state.establishmentDate ? this.state.establishmentDate.getTime() : null, 
            licenseNo: this.state.licenseNumber, validTill: this.state.validTill ? this.state.validTill.getTime() : null, firmType: this.state.firmType, 
            services: [this.state.serviceType], bankInfo: {
                bankName: this.state.bankName, branch: this.state.branch, ifscCode: this.state.ifsCode, accountNumber: this.state.accountNumber
            }, address: {
                line1: this.address.state.line1, line2: this.address.state.line2, city: this.address.state.city,
                state: this.address.state.state, pincode: this.address.state.pincode, landMark: this.address.state.landmark
            }
        };

        fetch('/finance/v1/firm', {
            method: 'POST', dataType: 'json', body: JSON.stringify(firmDetails), credentials: "same-origin",
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
                    <h3>Firm {this.props.mode === 'update' ? 'Updation' : 'Creation'}</h3>
                </header>
                <section className="section-content">
                    <h5>Firm Details</h5>
                    <div className="row">
                        <div className="col-lg-3 col-sm-12 col-md-6">
                            <Input type='text' label='Firm Id' onChange={this.handleChange.bind(this, 'firmId')}
                                maxLength={9} hint='Choose a unique firm Id' required value={this.state.firmId} />
                        </div>
                        <div className="col-lg-3 col-sm-12 col-md-6">
                            <Input type='text' label='Name' maxLength={9} value={this.state.firmName}
                                onChange={this.handleChange.bind(this, 'firmName')} />
                        </div>
                        <div className="col-lg-3 col-sm-12 col-md-6">
                            <Dropdown auto source={this.state.admins} label='Admin'
                                value={this.state.adminName} onChange={this.handleChange.bind(this, 'adminName')} />
                        </div>
                        <div className="col-lg-3 col-sm-12 col-md-6">
                            <Input type='email' label='Email Id' value={this.state.email}
                                onChange={this.handleChange.bind(this, 'email')} />
                        </div>
                        <div className="col-lg-3 col-sm-12 col-md-6">
                            <Input type='number' label='Phone Number 1' value={this.state.phone1}
                                onChange={this.handleChange.bind(this, 'phone1')} />
                        </div>
                        <div className="col-lg-3 col-sm-12 col-md-6">
                            <Input type='number' label='Phone Number 2' value={this.state.phone2}
                                onChange={this.handleChange.bind(this, 'phone2')} />
                        </div>
                        <div className="col-lg-3 col-sm-12 col-md-6">
                            <DatePicker label='Establishment Date' value={this.state.establishmentDate}
                                onChange={this.handleChange.bind(this, 'establishmentDate')} />
                        </div>
                        <div className="col-lg-3 col-sm-12 col-md-6">
                            <Input type='number' label='License Number' value={this.state.licenseNumber}
                                onChange={this.handleChange.bind(this, 'licenseNumber')} />
                        </div>
                        <div className="col-lg-3 col-sm-12 col-md-6">
                            <DatePicker label='Valid Till' value={this.state.validTill}
                                onChange={this.handleChange.bind(this, 'validTill')} />
                        </div>
                        <div className="col-lg-3 col-sm-12 col-md-6">
                            <Dropdown auto source={this.state.firmTypes} label='Firm Type'
                                value={this.state.firmType} onChange={this.handleChange.bind(this, 'firmType')} />
                        </div>
                        <div className="col-lg-3 col-sm-12 col-md-6">
                            <Dropdown auto source={this.state.services} label='Service Type'
                                value={this.state.serviceType} onChange={this.handleChange.bind(this, 'serviceType')} />
                        </div>
                    </div>
                </section>
                <AddressCreateCard ref={(address) => { this.address = address; }} />
                <section className="section-content">
                    <h5>Bank Details</h5>
                    <div className="row">
                        <div className="col-lg-3 col-sm-12 col-md-6">
                            <Input type='text' label='Bank Name' required value={this.state.bankName}
                                onChange={this.handleChange.bind(this, 'bankName')} />
                        </div>
                        <div className="col-lg-3 col-sm-12 col-md-6">
                            <Input type='text' label='Branch' value={this.state.branch}
                                onChange={this.handleChange.bind(this, 'branch')} />
                        </div>
                        <div className="col-lg-3 col-sm-12 col-md-6">
                            <Input type='text' label='IFSC Code' value={this.state.ifsCode}
                                onChange={this.handleChange.bind(this, 'ifsCode')} />
                        </div>
                        <div className="col-lg-3 col-sm-12 col-md-6">
                            <Input type='number' label='Account Number' value={this.state.accountNumber}
                                onChange={this.handleChange.bind(this, 'accountNumber')} />
                        </div>
                    </div>
                </section>
                <section>
                    <div className="row">
                        <div className="col-lg-12 col-sm-12 col-md-12">
                            <Button raised primary label="Submit" onClick={this.createFirm.bind(this)}
                                style={{ margin: '10px', float: 'right' }} />
                            <Button raised label="Cancel" style={{ margin: '10px', float: 'right' }} />
                        </div>
                    </div>
                </section>
            </section>
        );
    };
}

export default SuperAdminFirmCreateCard;