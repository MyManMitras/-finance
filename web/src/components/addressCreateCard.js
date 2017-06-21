import React from 'react';
import Card from 'react-toolbox/lib/card/Card';
import CardTitle from 'react-toolbox/lib/card/CardTitle';
import CardText from 'react-toolbox/lib/card/CardText';
import CardActions from 'react-toolbox/lib/card/CardActions';
import Button from 'react-toolbox/lib/button/Button';
import theme from '../style/card.css';
import Input from 'react-toolbox/lib/input/Input';
import DatePicker from 'react-toolbox/lib/date_picker/DatePicker';

class AddressCreateCard extends React.Component {

  render () {
      return (
             <section className="section-content">
                <h5>Address Details</h5>
                <div className="row">
                    <div className="col-lg-6 col-sm-12 col-md-12">
                        <Input type='text' label='Line 1' name='' 
                            maxLength={20} required/>
                    </div>
                    <div className="col-lg-6 col-sm-12 col-md-12">
                        <Input type='text' label='Line 2' name='' 
                            maxLength={20} />
                    </div>
                    <div className="col-lg-3 col-sm-12 col-md-6">
                        <Input type='text' label='Landmark' name=''/>
                    </div>
                    <div className="col-lg-3 col-sm-12 col-md-6">
                        <Input type='text' label='City' name=''/>
                    </div>
                    <div className="col-lg-3 col-sm-12 col-md-6">
                        <Input type='text' label='State' name='' />
                    </div>
                    <div className="col-lg-3 col-sm-12 col-md-6">
                        <Input type='number' label='Pin Code' name='' maxLength={6} required/>
                    </div>
                </div>
            </section>
    );
  };
}

export default AddressCreateCard;