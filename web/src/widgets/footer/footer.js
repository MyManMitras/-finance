import React from 'react';

const footerStyle = {
    textAlign: 'center',
    width: '100%',
    borderTop: '2px solid'

};

class Footer extends React.Component {
    render () {
        return (
            <footer style={footerStyle}>
                <span>For questions/queries/assitance/support get in touch with us. We are happy to help...</span><br/>
                <span>Email: MyManMitras@gmail.com / Call: NNNNNNNNNN</span><br/>
                <span>Address: Address ..................</span>
            </footer>
        );
    };

}

export default Footer;