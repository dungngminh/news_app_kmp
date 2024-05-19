//
//  AboutScreen.swift
//  iosApp
//
//  Created by Nguyễn Minh Dũng on 19/5/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import SwiftUI

struct AboutScreen: View {
    
    var body: some View {
        NavigationStack {
            AboutListView()
                .navigationTitle("About Screen")
        }
    }
}
