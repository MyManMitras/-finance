import React from 'react';
import Input from 'react-toolbox/lib/input/Input';
import _ from 'lodash';

class AddressCreateCard extends React.Component {
    state = {
        line1: '', line2: '', landmark: '', city: '',
        state: '', pincode: ''
    };

    constructor(props) {
        super(props);
        if (!_.isEmpty(props.address))
            this.state = this.getStateFromProps(props.address);
    };

    getStateFromProps = (address) => {
        return {
            line1: address.line1, line2: address.line2, landmark: address.landmark,
            city: address.city, state: address.state, pincode: address.pincode
        };
    };

    componentWillReceiveProps = function (nextProps) {
        if(nextProps.address) this.setState(this.getStateFromProps(nextProps.address));
    };

    handleChange = (field, value) => {
        this.setState({ ...this.state, [field]: value });
    };

    render() {
        return (
            <section className="section-content">
                <h5>Address Details</h5>
                <div className="row">
                    <div className="col-lg-6 col-sm-12 col-md-12">
                        <Input type='text' label='Line 1' onChange={this.handleChange.bind(this, 'line1')}
                            required value={this.state.line1} maxLength={20} />
                    </div>
                    <div className="col-lg-6 col-sm-12 col-md-12">
                        <Input type='text' label='Line 2' onChange={this.handleChange.bind(this, 'line2')}
                            required value={this.state.line2} maxLength={20} />
                    </div>
                    <div className="col-lg-3 col-sm-12 col-md-6">
                        <Input type='text' label='Landmark' onChange={this.handleChange.bind(this, 'landmark')}
                            required value={this.state.landmark} />
                    </div>
                    <div className="col-lg-3 col-sm-12 col-md-6">
                        <Input type='text' label='City' onChange={this.handleChange.bind(this, 'city')}
                            required value={this.state.city} />
                    </div>
                    <div className="col-lg-3 col-sm-12 col-md-6">
                        <Input type='text' label='State' onChange={this.handleChange.bind(this, 'state')}
                            required value={this.state.state} />
                    </div>
                    <div className="col-lg-3 col-sm-12 col-md-6">
                        <Input type='number' label='Pin Code' maxLength={6} onChange={this.handleChange.bind(this, 'pincode')}
                            required value={this.state.pincode} />
                    </div>
                </div>
            </section>
        );
    };
}

export default AddressCreateCard;