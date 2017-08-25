import React from 'react';
import Input from 'react-toolbox/lib/input/Input';
import Button from 'react-toolbox/lib/button/Button';
import FontIcon from 'react-toolbox/lib/font_icon/FontIcon';
import SuperAdminFirmCreateCard from '../../components/superAdminFirmCreateCard';
import PersonCreateCard from '../../components/personCreateCard';
import Table from '../../components/table/table';

const header = [
    {label: "Firm Name", key: "name"},
    {label: "Firm Id", key: "firmId"},
    {label: "Admin Name", key: "admin"},
    {label: "Phone Number1 ", key: "phone1"},
    {label: "Mail Id", key: "emailId"},
    {label: "Firm Type", key: "firmType"},
    {label: "Valid Till", key: "validTill", type: Date}
];
/*
const data = [
    {
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
        serviceType: 'Both Asset and Non Asset Services'
    },{
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
        serviceType: 'Both Asset and Non Asset Services'
    }
]; */

class SuperAdminDashboard extends React.Component {
    state = {
        firmDetails: {
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
        }, mode: 'init', searchText: '', firms: []
    };

    editFirm = (data) => {
        this.setState({
            mode: 'update'
        });
    };

    getFirmUpdateCard = () => {
        if (this.state.mode === 'update' || this.state.mode === 'createFirm') {
            return (<SuperAdminFirmCreateCard />);
        }
        else if (this.state.mode === 'createAdmin') {
            return (<PersonCreateCard type="Admin" />);
        }
        else if (this.state.mode === 'init' && this.state.firms.length > 0){
            return (<Table headers={header} data={this.state.firms} click={this.editFirm.bind(this)}/>);
        } else {
            return null;
        }
    };

    changeMode = (mode) => {
        this.setState({ mode: mode });
    };

    handleChange = (field, value) => {
        this.setState({ ...this.state, [field]: value });
    };

    loadFirms = () => {
        fetch('/finance/v1/firm/search/' + (this.state.searchText || 'all'), {
            accept: 'application/json', credentials: "same-origin", headers: { 'Content-Type': 'application/json' }
        })
        .then(response => {
            response.json()
                .then(data => {
                    this.setState({
                        firms: data
                    });
                });
        }, error => {
            console.log('error: ' + error);
        });
    };

    searchFirms = () =>{
        this.loadFirms();
        this.changeMode('init');
    };
/*
    componentWillMount() {
        this.loadFirms();
    }; */

    render() {
        return (
            <div className="row">
                <div className="col-lg-6 col-sm-6 col-md-6">
                    <div className="row" style={{ margin: 0 }}>
                        <div className="col-lg-1 col-sm-1 col-md-1 col-1">
                            <FontIcon value='search' style={{ fontSize: '-webkit-xxx-large' }} />
                        </div>
                        <div className="col-lg-8 col-sm-8 col-md-8 col-8">
                            <Input type='search' placeholder="Enter Firm name or Admin name & Search" className="dashboard-input" 
                               onChange={this.handleChange.bind(this, 'searchText')} value={this.state.searchText}/>
                        </div>
                        <div className="col-lg-3 col-sm-3 col-md-3 col-3">
                            <Button label='Search Firm' raised primary onClick={this.searchFirms.bind(this)} />
                        </div>
                    </div>
                </div>
                <div className="col-lg-6 col-sm-6 col-md-6">
                    <Button label='Create Admin' raised
                        className="super-admin-dashboard-button" onClick={this.changeMode.bind(this, 'createAdmin')} />
                    <Button label='Create New Firm' raised primary
                        className="super-admin-dashboard-button" onClick={this.changeMode.bind(this, 'createFirm')} />
                </div>
                <div className="col-lg-12 col-sm-12 col-md-12">
                    {this.getFirmUpdateCard()}
                </div>
            </div>
        );
    }
}

export default SuperAdminDashboard;