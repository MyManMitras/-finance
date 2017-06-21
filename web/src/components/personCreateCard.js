import React from 'react';
import Card from 'react-toolbox/lib/card/Card';
import CardTitle from 'react-toolbox/lib/card/CardTitle';
import CardText from 'react-toolbox/lib/card/CardText';
import CardActions from 'react-toolbox/lib/card/CardActions';
import Button from 'react-toolbox/lib/button/Button';
import theme from '../style/card.css';
import Input from 'react-toolbox/lib/input/Input';
import DatePicker from 'react-toolbox/lib/date_picker/DatePicker';
import AddressCreateCard from './addressCreateCard';

class PersonCreateCard extends React.Component {

  render () {
      return (
          <section>
            <header>
                <h3>{this.props.type || 'Person'} Creation</h3>
            </header>
             <section className="section-content">
                <h5>{this.props.type || 'Person'} Details</h5>
                <div className="row">
                    <div className="col-lg-3 col-sm-12 col-md-6">
                        <Input type='text' label='First Name' name='' required/>
                    </div>
                    <div className="col-lg-3 col-sm-12 col-md-6">
                        <Input type='text' label='Last Name' name='' />
                    </div>
                    <div className="col-lg-3 col-sm-12 col-md-6">
                        <DatePicker label='Date of Birth' />
                    </div>
                    <div className="col-lg-3 col-sm-12 col-md-6">
                        <Input type='text' label='Gender' name='' />
                    </div>
                    <div className="col-lg-3 col-sm-12 col-md-6">
                        <Input type='text' label='Login Id' name='' maxLength={9}
                            maxLength={9} hint='Choose a unique firm Id' required/>
                    </div>
                    <div className="col-lg-3 col-sm-12 col-md-6">
                        <Input type='password' label='Password' name='' 
                            maxLength={9} hint='Choose a unique firm Id' required/>
                    </div>
                    <div className="col-lg-3 col-sm-12 col-md-6">
                        <Input type='password' label='Confirm Password' name='' 
                            maxLength={9} hint='Choose a unique firm Id' required/>
                    </div>
                    <div className="col-lg-3 col-sm-12 col-md-6">
                        <Input type='email' label='Email Id' name='' />
                    </div>
                    <div className="col-lg-3 col-sm-12 col-md-6">
                        <Input type='number' label='Phone Number' name=''/>
                    </div>
                    <div className="col-lg-3 col-sm-12 col-md-6">
                        <Input type='text' label='Role' name='' maxLength={9} />
                    </div>
                    {(function(){
                        if(this.props.type != 'Admin') {
                        return (<div className="col-lg-3 col-sm-12 col-md-6">
                                    <Input type='text' label='Firm Id' name='' maxLength={9} />
                                </div>)} 
                    return null;}).bind(this)()
                    }
                </div>
            </section>
            <AddressCreateCard/>
        </section>
    );
  };
}

export default PersonCreateCard;