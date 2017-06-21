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

class SuperAdminFirmCreateCard extends React.Component {

  state = {overview: {},hint: '',firm: {address: {}}};
  
  componentWillReceiveProps(nextProps){
      if(nextProps.mode !=='update') {
        this.setState({firm: {
            firmId: '',
            firmName: '',
            adminName: '',
            email: '',
            phone1: '',
            phone2: '',
            establishmentDate: null,
            licenseNumber: '',
            validTill: null,
            firmType: '',
            serviceType: '',
            bankInfo: {
                bankName: '',
                branch: '',
                ifsCode: '',
                accountNumber: ''
            },
            address: {

            }
        }
    });
    }else if(nextProps.mode ==='update')
        this.setState({firm: {
            firmId: 'svf3131',
            firmName: 'Sri Venkateshwara Finance',
            adminName: 'Shiv Kumar',
            email: 'bnShivKumar@gmail.com',
            phone1: '8880003339',
            phone2: '08231243534',
            establishmentDate: new Date(2015, 10, 16),
            licenseNumber: 31232123,
            validTill: new Date(2025, 10, 16),
            firmType: 'Partnership',
            serviceType: 'Both Asset and Non Asset Services',
            bankInfo: {
                bankName: 'Cindicate Bank Ltd',
                branch: 'Malavalli',
                ifsCode: 'CIN3123EE124',
                accountNumber: 9912378402
            },
            address: {

            }
        }
    }); 
  };
  componentWillMount() {
      if(this.props.mode ==='update')
        this.setState({firm: {
            firmId: 'svf3131',
            firmName: 'Sri Venkateshwara Finance',
            adminName: 'Shiv Kumar',
            email: 'bnShivKumar@gmail.com',
            phone1: '8880003339',
            phone2: '08231243534',
            establishmentDate: new Date(2015, 10, 16),
            licenseNumber: 31232123,
            validTill: new Date(2025, 10, 16),
            firmType: 'Partnership',
            serviceType: 'Both Asset and Non Asset Services',
            bankInfo: {
                bankName: 'Cindicate Bank Ltd',
                branch: 'Malavalli',
                ifsCode: 'CIN3123EE124',
                accountNumber: 9912378402
            },
            address: {

            }
        }
    });
        else
            this.setState({firm: {
                    address: {},
                    bankInfo: {}
                }
            });
    fetch('/finance/v1/dashboard/firmOverview/'+this.props.firmId,{accept: 'application/json'}).then(response=>{
      response.json().then(data=>{
        this.setState({overview: data});
      });
    }, error=>{
      console.log('error: ' + error);
    });
  };
  render () {
    return (
        <section>
            <header>
                <h3>Firm {this.props.mode ==='update' ? 'Updation' : 'Creation'}</h3>
            </header>
            <section className="section-content">
                <h5>Firm Details</h5>
                <div className="row">
                    <div className="col-lg-3 col-sm-12 col-md-6">
                        <Input type='text' label='Firm Id' name='' value={this.state.hint} disabled={this.props.mode ==='update'}
                            maxLength={9} hint='Choose a unique firm Id' required value={this.state.firm.firmId}/>
                    </div>
                    <div className="col-lg-3 col-sm-12 col-md-6">
                        <Input type='text' label='Name' name='' maxLength={9} value={this.state.firm.firmName}/>
                    </div>
                    <div className="col-lg-3 col-sm-12 col-md-6">
                        <Input type='text' label='Admin Name' name='' maxLength={9} disabled={this.props.mode ==='update'}
                        value={this.state.firm.adminName}/>
                    </div>
                    <div className="col-lg-3 col-sm-12 col-md-6">
                        <Input type='email' label='Email Id' name='' value={this.state.firm.email}/>
                    </div>
                    <div className="col-lg-3 col-sm-12 col-md-6">
                        <Input type='number' label='Phone Number 1' name='' value={this.state.firm.phone1}/>
                    </div>
                    <div className="col-lg-3 col-sm-12 col-md-6">
                        <Input type='number' label='Phone Number 2' name='' value={this.state.firm.phone2}/>
                    </div>
                    <div className="col-lg-3 col-sm-12 col-md-6">
                        <DatePicker label='Establishment Date' value={this.state.firm.establishmentDate}/>
                    </div>
                    <div className="col-lg-3 col-sm-12 col-md-6">
                        <Input type='number' label='License Number' name='' value={this.state.firm.licenseNumber}/>
                    </div>
                    <div className="col-lg-3 col-sm-12 col-md-6">
                        <DatePicker label='Valid Till' value={this.state.firm.validTill}/>
                    </div>
                    <div className="col-lg-3 col-sm-12 col-md-6">
                        <Input type='text' label='Firm Type' name='' value={this.state.firm.firmType}/>
                    </div>
                    <div className="col-lg-3 col-sm-12 col-md-6">
                        <Input type='text' label='Services Provided' name='' value={this.state.firm.serviceType}/>
                    </div>
                </div>
            </section>
            <AddressCreateCard/>
             <section className="section-content">
                <h5>Bank Details</h5>
                <div className="row">
                    <div className="col-lg-3 col-sm-12 col-md-6">
                        <Input type='text' label='Bank Name' name='' required value={this.state.firm.bankInfo.bankName}/>
                    </div>
                    <div className="col-lg-3 col-sm-12 col-md-6">
                        <Input type='text' label='Branch' name=''  value={this.state.firm.bankInfo.branch}/>
                    </div>
                    <div className="col-lg-3 col-sm-12 col-md-6">
                        <Input type='text' label='IFSC Code' name='' value={this.state.firm.bankInfo.ifsCode}/>
                    </div>
                    <div className="col-lg-3 col-sm-12 col-md-6">
                        <Input type='text' label='Account Number' name='' value={this.state.firm.bankInfo.accountNumber}/>
                    </div>
                </div>
            </section>
            <footer>
                <Button label='Submit' primary raised></Button>
                <Button label='Cancel' primary ></Button>
            </footer>
        </section>
    );
  };
}

export default SuperAdminFirmCreateCard;