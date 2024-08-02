//
//  SmsManager.swift
//  iosApp
//
//  Created by mohab erabi on 02/08/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import UIKit

@objc public class SmsManager: NSObject {

    @objc public static func sendSms(to: String, message: String) {
        let sms = "sms:\(to)&body=\(message)"
        if let strUrl = sms.addingPercentEncoding(withAllowedCharacters: .urlQueryAllowed),
           let url = URL(string: strUrl) {
            UIApplication.shared.open(url, options: [:], completionHandler: nil)
        } else {
            print("Error sending SMS")
        }
    }
}
