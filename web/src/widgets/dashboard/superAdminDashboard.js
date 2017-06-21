import React from 'react';
import Card from 'react-toolbox/lib/card/Card';
import CardTitle from 'react-toolbox/lib/card/CardTitle';
import Input from 'react-toolbox/lib/input/Input';
import Button from 'react-toolbox/lib/button/Button';
import FontIcon from 'react-toolbox/lib/font_icon/FontIcon';
import SuperAdminFirmUpdateCard from '../../components/superAdminFirmUpdateCard';
import SuperAdminFirmCreateCard from '../../components/superAdminFirmCreateCard';
import PersonCreateCard from '../../components/personCreateCard';

class SuperAdminDashboard extends React.Component {
    state = {firmDetails: {}, mode: ''};

    getFirmUpdateCard = () => {
        if(this.state.mode == 'update'){
            return (<SuperAdminFirmCreateCard mode="update"/>);
        }
        else if(this.state.mode == 'createAdmin'){
            return (<PersonCreateCard type="Admin"/>);
        }
        else if(this.state.mode == 'createFirm') {
            return (<SuperAdminFirmCreateCard mode="create"/>);
        }
        else {
            return null;
        }
    };

    changeMode = (mode) => {
        this.setState({mode: mode});
    };

  render () {
    return (
        <div className="row">
            <div className="col-lg-6 col-sm-6 col-md-6">
                <div className="row" style={{margin: 0}}>
                    <div className="col-lg-1 col-sm-1 col-md-1 col-1">
                        <FontIcon value='search' style={{fontSize: '-webkit-xxx-large'}}/>
                    </div>
                    <div className="col-lg-8 col-sm-8 col-md-8 col-8">
                        <Input type='search' placeholder="Enter Firm ID or Admin Phone Number" className="dashboard-input"/>
                    </div>
                    <div className="col-lg-3 col-sm-3 col-md-3 col-3">
                        <Button label='Search Firm' raised primary onClick={this.changeMode.bind(this,'update')}/>
                    </div>
                </div>
            </div>
            <div className="col-lg-6 col-sm-6 col-md-6">
                <Button label='Create Admin' raised 
                    className="super-admin-dashboard-button" onClick={this.changeMode.bind(this, 'createAdmin')}/>
                <Button label='Create New Firm' raised primary 
                    className="super-admin-dashboard-button" onClick={this.changeMode.bind(this, 'createFirm')}/>
            </div>
            <div className="col-lg-12 col-sm-12 col-md-12">
                {this.getFirmUpdateCard()}
            </div>            
        </div>
    );
  }
}

export default SuperAdminDashboard;